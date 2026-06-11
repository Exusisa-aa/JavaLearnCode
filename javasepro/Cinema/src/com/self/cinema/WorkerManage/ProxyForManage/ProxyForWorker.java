package com.self.cinema.WorkerManage.ProxyForManage;

import com.self.cinema.CinemaManage.CinemaManagerManagement;
import com.self.cinema.CinemaManage.ProxyForManage.ProxyForManage;
import com.self.cinema.WorkerManage.CinemaWorkerManagement;
import com.self.cinema.WorkerManage.LoadAndUpdateWorkersMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyForWorker{
    public static final Logger LOGGER = LoggerFactory.getLogger("LogTracerForWorker");

    public static CinemaForWorker createProxy(CinemaWorkerManagement cinemaWorkerManagement){
        CinemaForWorker proxy = (CinemaForWorker) Proxy.newProxyInstance(ProxyForWorker.class.getClassLoader(),
                new Class[]{CinemaForWorker.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if(method.getName().equals("addWorker")){
                            try {
                                Object result = method.invoke(cinemaWorkerManagement, args);
                                CinemaWorkerManagement.updateIOsAndLog();
                                LoadAndUpdateWorkersMessage.LoadWorkersMessageMethod();
                                ProxyForManage.LOGGER.info("管理员添加了员工");
                                return result;
                            } catch (IllegalAccessException e) {
                                ProxyForManage.LOGGER.error("权限不足无法访问，无法添加员工");
                                throw new RuntimeException(e);
                            } catch (IllegalArgumentException e) {
                                ProxyForManage.LOGGER.error("参数错误，无法添加员工");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                ProxyForManage.LOGGER.error("方法有bug，无法添加员工");
                                throw new RuntimeException(e);
                            }
                        } else if (method.getName().equals("fireWorker")) {
                            try {
                                Object result = method.invoke(cinemaWorkerManagement, args);
                                CinemaWorkerManagement.updateIOsAndLog();
                                LoadAndUpdateWorkersMessage.LoadWorkersMessageMethod();
                                ProxyForManage.LOGGER.info("管理员删除了员工");
                                return result;
                            } catch (IllegalAccessException e) {
                                ProxyForManage.LOGGER.error("权限不足无法访问，无法删除员工");
                                throw new RuntimeException(e);
                            } catch (IllegalArgumentException e) {
                                ProxyForManage.LOGGER.error("参数错误，无法删除员工");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                ProxyForManage.LOGGER.error("方法有bug，无法删除员工");
                                throw new RuntimeException(e);
                            }
                        } else if (method.getName().equals("increaseSalary")) {
                            try {
                                Object result = method.invoke(cinemaWorkerManagement, args);
                                CinemaWorkerManagement.updateIOsAndLog();
                                LoadAndUpdateWorkersMessage.LoadWorkersMessageMethod();
                                ProxyForManage.LOGGER.info("管理员给员工添加了工资");
                                return result;
                            } catch (IllegalAccessException e) {
                                ProxyForManage.LOGGER.error("权限不足无法访问，无法给员工添加工资");
                                throw new RuntimeException(e);
                            } catch (IllegalArgumentException e) {
                                ProxyForManage.LOGGER.error("参数错误，无法给员工添加工资");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                ProxyForManage.LOGGER.error("方法有bug，无法给员工添加工资");
                                throw new RuntimeException(e);
                            }
                        } else if (method.getName().equals("updateWorker")) {
                            try {
                                Object result = method.invoke(cinemaWorkerManagement, args);
                                CinemaWorkerManagement.updateIOsAndLog();
                                LoadAndUpdateWorkersMessage.LoadWorkersMessageMethod();
                                ProxyForManage.LOGGER.info("管理员更新了员工信息");
                                return result;
                            } catch (IllegalAccessException e) {
                                ProxyForManage.LOGGER.error("权限不足无法访问，无法更新员工信息");
                                throw new RuntimeException(e);
                            } catch (IllegalArgumentException e) {
                                ProxyForManage.LOGGER.error("参数错误，无法更新员工信息");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                ProxyForManage.LOGGER.error("方法有bug，无法更新员工信息");
                                throw new RuntimeException(e);
                            }
                        } else if (method.getName().equals("showWorkerInfo")) {
                            try {
                                Object result = method.invoke(cinemaWorkerManagement, args);
                                ProxyForManage.LOGGER.info("管理员查看了员工信息");
                                return result;
                            } catch (IllegalAccessException e) {
                                ProxyForManage.LOGGER.error("权限不足无法访问，无法查看员工信息");
                                throw new RuntimeException(e);
                            } catch (IllegalArgumentException e) {
                                ProxyForManage.LOGGER.error("参数错误，无法查看员工信息");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                ProxyForManage.LOGGER.error("方法有bug，无法查看员工信息");
                                throw new RuntimeException(e);
                            }
                        } else if (method.getName().equals("startSystemForWorker")) {
                            try {
                                LOGGER.info("员工启动了员工系统");
                                return method.invoke(cinemaWorkerManagement, args);
                            } catch (IllegalAccessException e) {
                                LOGGER.error("权限不足无法访问，员工系统启动失败");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，员工系统启动失败");
                                throw new RuntimeException(e);
                            }
                        } else if (method.getName().equals("workerLogin")) {
                            try {
                                CinemaWorkerManagement.flushIOAndLog();
                                Object result = method.invoke(cinemaWorkerManagement, args);
                                LOGGER.info("员工正在登录");
                                return result;
                            }catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，执行失败");
                                throw new RuntimeException(e);
                            }
                        } else if (method.getName().equals("successLogin")) {
                            try {
                                //更新影院信息
                                CinemaManagerManagement.flushCinema();
                                //更新xml
                                LoadAndUpdateWorkersMessage.LoadWorkersMessageMethod();
                                LOGGER.info("员工登录成功");
                                return method.invoke(cinemaWorkerManagement, args);
                            } catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，登录执行失败");
                                throw new RuntimeException(e);
                            }
                        } else if (method.getName().equals("changePassword")) {
                            try {
                                Object result = method.invoke(cinemaWorkerManagement, args);
                                CinemaWorkerManagement.updateIOsAndLog();
                                LoadAndUpdateWorkersMessage.LoadWorkersMessageMethod();
                                LOGGER.info("员工修改了密码");
                                return result;
                            } catch (IllegalAccessException e) {
                                LOGGER.error("权限不足无法访问，员工修改密码失败");
                                throw new RuntimeException(e);
                            } catch (IllegalArgumentException e) {
                                LOGGER.error("参数错误，员工修改密码失败");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，员工修改密码失败");
                                throw new RuntimeException(e);
                            }
                        } else if (method.getName().equals("leaveApplicate")) {
                            try {
                                Object result = method.invoke(cinemaWorkerManagement, args);
                                LOGGER.info("员工申请了请假");
                                return result;
                            } catch (IllegalAccessException e) {
                                LOGGER.error("权限不足无法访问，员工申请请假失败");
                                throw new RuntimeException(e);
                            } catch (IllegalArgumentException e) {
                                LOGGER.error("参数错误，员工申请请假失败");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，员工申请请假失败");
                                throw new RuntimeException(e);
                            }
                        } else if (method.getName().equals("printLeaveApplications")) {
                            try {
                                CinemaWorkerManagement.flushIOAndLog();//!!不能删
                                Object result = method.invoke(cinemaWorkerManagement, args);
                                CinemaWorkerManagement.updateIOsAndLog();
                                LoadAndUpdateWorkersMessage.LoadWorkersMessageMethod();
                                LOGGER.info("管理员查看了请假申请");
                                return result;
                            } catch (IllegalAccessException e) {
                                LOGGER.error("权限不足无法访问，管理员查看请假申请失败");
                                throw new RuntimeException(e);
                            } catch (IllegalArgumentException e) {
                                LOGGER.error("参数错误，管理员查看请假申请失败");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，员工查看请假申请失败");
                                throw new RuntimeException(e);
                            }
                        }
                        return method.invoke(cinemaWorkerManagement, args);
                    }
                });
        return proxy;
    }


}
