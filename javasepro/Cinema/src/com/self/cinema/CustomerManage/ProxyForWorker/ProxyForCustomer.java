package com.self.cinema.CustomerManage.ProxyForWorker;

import com.self.cinema.CinemaManage.CinemaManagerManagement;
import com.self.cinema.CinemaManage.LoadAndUpdateCinemaMessage;
import com.self.cinema.CustomerManage.CinemaCustomerManagement;
import com.self.cinema.CustomerManage.LoadAndUpdateCustomerMessage;
import com.self.cinema.WorkerManage.ProxyForManage.ProxyForWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyForCustomer {

    public static final Logger LOGGER = LoggerFactory.getLogger("LogTracerForCustomer");
    public static CinemaForCustomer createProxy(CinemaForCustomer cinemaForCustomer){
        CinemaForCustomer proxy = (CinemaForCustomer) Proxy.newProxyInstance(ProxyForWorker.class.getClassLoader(),
                new Class[]{CinemaForCustomer.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if(method.getName().equals("startSystemForCustomer")){
                            try {
                                LOGGER.info("用户系统已启动");
                                return method.invoke(cinemaForCustomer, args);
                            } catch (IllegalAccessException e) {
                                LOGGER.error("权限不足无法访问，用户系统启动失败");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，启动失败");
                                throw new RuntimeException(e);
                            }
                        } else if (method.getName().equals("customerLogin")) {
                            Object result;
                            try {
                                CinemaCustomerManagement.flushIOAndLog();
                                result = method.invoke(cinemaForCustomer, args);
                                LOGGER.info("用户正在登陆中");
                            }catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，执行失败");
                                throw new RuntimeException(e);
                            }
                            return result;
                        }else if (method.getName().equals("successLogin")) {
                            try {
                                //更新影院信息
                                CinemaManagerManagement.flushCinema();
                                //更新xml
                                LoadAndUpdateCustomerMessage.LoadCustomersMessageMethod();
                                LOGGER.info("用户登陆成功");
                                return method.invoke(cinemaForCustomer, args);
                            } catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，登录执行失败");
                                throw new RuntimeException(e);
                            }
                        } else if (method.getName().equals("createCustomer")) {
                            try {
                                CinemaCustomerManagement.flushIOAndLog();
                                Object result = method.invoke(cinemaForCustomer, args);
                                CinemaCustomerManagement.updateIOsAndLog();
                                LoadAndUpdateCustomerMessage.LoadCustomersMessageMethod();
                                LOGGER.info("用户创建成功");
                                return result;
                            } catch (IllegalAccessException e) {
                                LOGGER.error("权限不足无法访问，创建用户失败");
                                throw new RuntimeException(e);
                            } catch (IllegalArgumentException e) {
                                LOGGER.error("参数有误，创建用户失败");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，创建用户失败");
                                throw new RuntimeException(e);
                            }
                        } else if (method.getName().equals("showMovieInfo")) {
                            try {
                                Object result = method.invoke(cinemaForCustomer, args);
                                CinemaManagerManagement.flushCinema();
                                LOGGER.info("用户正在查看电影信息");
                                return result;
                            } catch (IllegalAccessException e) {
                                LOGGER.error("权限不足无法访问，查看电影信息失败");
                                throw new RuntimeException(e);
                            } catch (IllegalArgumentException e) {
                                LOGGER.error("参数有误，查看电影信息失败");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，查看电影信息失败");
                                throw new RuntimeException(e);
                            }
                        }else if (method.getName().equals("showMoneyAndInfo")) {
                            try {
                                Object result = method.invoke(cinemaForCustomer, args);
                                CinemaCustomerManagement.updateIOsAndLog();
                                LOGGER.info("用户查看了账户信息");
                                return result;
                            } catch (IllegalAccessException e) {
                                LOGGER.error("权限不足无法访问，查看账户信息失败");
                                throw new RuntimeException(e);
                            } catch (IllegalArgumentException e) {
                                LOGGER.error("参数有误，查看账户信息失败");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，查看账户信息失败");
                                throw new RuntimeException(e);
                            }
                        }else if (method.getName().equals("addMoney")) {
                            try {
                                Object result = method.invoke(cinemaForCustomer, args);
                                CinemaCustomerManagement.updateIOsAndLog();
                                LoadAndUpdateCustomerMessage.LoadCustomersMessageMethod();
                                LOGGER.info("用户充值成功");
                                return result;
                            } catch (IllegalAccessException e) {
                                LOGGER.error("权限不足无法访问，充值失败");
                                throw new RuntimeException(e);
                            } catch (IllegalArgumentException e) {
                                LOGGER.error("参数有误，充值失败");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，充值失败");
                                throw new RuntimeException(e);
                            }
                        }else if (method.getName().equals("toFeedback")) {
                            try {
                                Object result = method.invoke(cinemaForCustomer, args);
                                CinemaCustomerManagement.updateIOsAndLog();
                                LoadAndUpdateCustomerMessage.LoadCustomersMessageMethod();
                                LOGGER.info("用户提交了评论");
                                return result;
                            } catch (IllegalAccessException e) {
                                LOGGER.error("权限不足无法访问，提交评论失败");
                                throw new RuntimeException(e);
                            } catch (IllegalArgumentException e) {
                                LOGGER.error("参数有误，提交评论失败");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，提交评论失败");
                                throw new RuntimeException(e);
                            }
                        }else if (method.getName().equals("addFriend")) {
                            try {
                                CinemaCustomerManagement.flushIOAndLog();
                                Object result = method.invoke(cinemaForCustomer, args);
                                CinemaCustomerManagement.updateIOsAndLog();
                                LoadAndUpdateCustomerMessage.LoadCustomersMessageMethod();
                                LOGGER.info("用户添加了好友");
                                return result;
                            } catch (IllegalAccessException e) {
                                LOGGER.error("权限不足无法访问，添加好友失败");
                                throw new RuntimeException(e);
                            } catch (IllegalArgumentException e) {
                                LOGGER.error("参数有误，添加好友失败");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，添加好友失败");
                                throw new RuntimeException(e);
                            }
                        }else if (method.getName().equals("chatWithFriend")) {
                            try {
                                CinemaCustomerManagement.flushIOAndLog();
                                Object result = method.invoke(cinemaForCustomer, args);
                                CinemaCustomerManagement.updateIOsAndLog();
                                LOGGER.info("用户开始与好友聊天");
                                return result;
                            } catch (IllegalAccessException e) {
                                LOGGER.error("权限不足无法访问，与好友聊天失败");
                                throw new RuntimeException(e);
                            } catch (IllegalArgumentException e) {
                                LOGGER.error("参数有误，与好友聊天失败");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，与好友聊天失败");
                                throw new RuntimeException(e);
                            }
                        }else if (method.getName().equals("buyTicket")) {
                            try {
                                CinemaCustomerManagement.flushIOAndLog();
                                LoadAndUpdateCinemaMessage.LoadCinemaMessageMethod();//加载
                                CinemaManagerManagement.flushCinema();//获得
                                Object result = method.invoke(cinemaForCustomer, args);
                                CinemaManagerManagement.updateCinema();
                                CinemaManagerManagement.flushCinema();

                                CinemaCustomerManagement.updateIOsAndLog();//存record
                                LoadAndUpdateCustomerMessage.LoadCustomersMessageMethod();//更新xml
                                LOGGER.info("用户成功购买了票");
                                return result;
                            } catch (IllegalAccessException e) {
                                LOGGER.error("权限不足无法访问，购买票失败");
                                throw new RuntimeException(e);
                            } catch (IllegalArgumentException e) {
                                LOGGER.error("参数有误，购买票失败");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，购买票失败");
                                throw new RuntimeException(e);
                            }
                        }else if (method.getName().equals("returnTicket")) {
                            try {
                                CinemaCustomerManagement.flushIOAndLog();
                                LoadAndUpdateCinemaMessage.LoadCinemaMessageMethod();//加载
                                CinemaManagerManagement.flushCinema();//获得
                                Object result = method.invoke(cinemaForCustomer, args);
                                CinemaManagerManagement.updateCinema();
                                CinemaManagerManagement.flushCinema();

                                CinemaCustomerManagement.updateIOsAndLog();//存record
                                LoadAndUpdateCustomerMessage.LoadCustomersMessageMethod();//更新xml
                                LOGGER.info("用户成功退票了");
                                return result;
                            } catch (IllegalAccessException e) {
                                LOGGER.error("权限不足无法访问，退票失败");
                                throw new RuntimeException(e);
                            } catch (IllegalArgumentException e) {
                                LOGGER.error("参数有误，退票失败");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，退票失败");
                                throw new RuntimeException(e);
                            }
                        }else if (method.getName().equals("printRecord")) {
                            try {
                                CinemaCustomerManagement.flushIOAndLog();
                                Object result = method.invoke(cinemaForCustomer, args);
                                LOGGER.info("用户查看了购票记录");
                                return result;
                            } catch (IllegalAccessException e) {
                                LOGGER.error("权限不足无法访问，查看购票记录失败");
                                throw new RuntimeException(e);
                            } catch (IllegalArgumentException e) {
                                LOGGER.error("参数有误，查看购票记录失败");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，查看购票记录失败");
                                throw new RuntimeException(e);
                            }
                        }
                        return method.invoke(cinemaForCustomer, args);
                    }
                });
        return proxy;
    }
}
