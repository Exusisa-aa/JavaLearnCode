package com.self.cinema.CinemaManage.ProxyForManage;
import com.self.cinema.CinemaManage.CinemaManagerManagement;
import com.self.cinema.CinemaManage.LoadAndUpdateCinemaMessage;
import com.self.cinema.WorkerManage.CinemaWorkerManagement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyForManage {
    public static final Logger LOGGER = LoggerFactory.getLogger("LogTracerForManager");
    public static CinemaForManager createProxy(CinemaManagerManagement cinemaManager){
        CinemaForManager proxy = (CinemaForManager) Proxy.newProxyInstance(ProxyForManage.class.getClassLoader(),
                new Class[]{CinemaForManager.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if(method.getName().equals("startSystemForManage")){
                            try {
                                LOGGER.info("管理员系统已启动");
                                return method.invoke(cinemaManager, args);
                            } catch (IllegalAccessException e) {
                                LOGGER.error("权限不足无法访问，管理员系统启动失败");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，启动失败");
                                throw new RuntimeException(e);
                            }
                        } else if (method.getName().equals("managerLogin")) {
                            try {
                                Object result = method.invoke(cinemaManager, args);
                                LOGGER.info("管理员正在登录");
                                return result;
                            }catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，执行失败");
                                throw new RuntimeException(e);
                            }
                        } else if (method.getName().equals("successLogin")) {
                            try {
                                LOGGER.info("管理员登录成功");
                                return method.invoke(cinemaManager, args);
                            } catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，登录执行失败");
                                throw new RuntimeException(e);
                            }
                        } else if (method.getName().equals("showHallInfo")) {
                            try {
                                CinemaManagerManagement.flushCinema();
                                Object result = method.invoke(cinemaManager, args);
                                LOGGER.info("管理员查看了厅信息");
                                return result;
                            } catch (IllegalAccessException e) {
                                LOGGER.error("权限不足无法访问，查看厅信息失败");
                                throw new RuntimeException(e);
                            } catch (IllegalArgumentException e) {
                                LOGGER.error("参数不合法，无法访问厅信息");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，无法访问厅信息");
                                throw new RuntimeException(e);
                            }
                        } else if (method.getName().equals("deviceDamageDeclare")) {
                            try {
                                Object result = method.invoke(cinemaManager, args);
                                LoadAndUpdateCinemaMessage.LoadCinemaMessageMethod();//更新电影院信息
                                CinemaManagerManagement.updateCinema();//更新影院信息
                                CinemaManagerManagement.flushCinema();

                                CinemaWorkerManagement.flushIOAndLog();
                                new CinemaWorkerManagement().updateAll();

                                LOGGER.info("管理员报备了设备损坏");
                                return result;
                            } catch (IllegalAccessException e) {
                                LOGGER.error("权限不足无法访问，无法报备厅的维修");
                                throw new RuntimeException(e);
                            } catch (IllegalArgumentException e) {
                                LOGGER.error("参数错误，无法报备厅维修");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，无法报备厅维修");
                                throw new RuntimeException(e);
                            }
                        } else if (method.getName().equals("deviceRepairDeclare")) {
                            try {
                                Object result = method.invoke(cinemaManager, args);
                                LoadAndUpdateCinemaMessage.LoadCinemaMessageMethod();
                                CinemaManagerManagement.updateCinema();
                                CinemaManagerManagement.flushCinema();

                                CinemaWorkerManagement.flushIOAndLog();
                                new CinemaWorkerManagement().updateAll();

                                LOGGER.info("管理员确认了设备已维修，取消了报备");
                                return result;
                            } catch (IllegalAccessException e) {
                                LOGGER.error("权限不足无法访问，无法撤回厅的维修");
                                throw new RuntimeException(e);
                            } catch (IllegalArgumentException e) {
                                LOGGER.error("参数错误，无法撤回厅维修");
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                LOGGER.error("方法有bug，无法撤回厅维修");
                                throw new RuntimeException(e);
                            }
                        } else if (method.getName().equals("printHallInfo")) {
                            //这里不要加载
                            return method.invoke(cinemaManager, args);
                        }
                        return method.invoke(cinemaManager, args);
                    }
                });
        return proxy;
    }


}
