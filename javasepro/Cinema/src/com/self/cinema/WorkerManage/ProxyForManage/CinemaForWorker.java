package com.self.cinema.WorkerManage.ProxyForManage;

import com.self.cinema.WorkerManage.Workers.Worker;

public interface CinemaForWorker {
    void startSystemForWorker();
    Worker workerLogin();
    void successLogin(Worker worker);
    boolean changePassword(Worker worker);
    boolean leaveApplicate(Worker worker);

    void addWorker();
    void fireWorker();
    void increaseSalary();
    void updateWorker(String workType, Worker worker,boolean isAdd);
    void showWorkerInfo();
    void printLeaveApplications();
}
