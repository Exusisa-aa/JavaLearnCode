package com.self.learnFile.service.implement;
import com.self.learnFile.service.WorkServiceFramework;
import org.springframework.stereotype.Service;


@Service("workServiceImpl")
public class WorkService implements WorkServiceFramework {
    @Override
    public void save() {
        System.out.println("save work...");
    }

    @Override
    public void update() {
        System.out.println("update work...");
    }

    @Override
    public void delete() {
        System.out.println("delete work...");
    }

    @Override
    public void select() {
        System.out.println("select work...");
    }

    @Override
    public int selectCount() {
        System.out.println("selectCount work...");
        int count = 200;
        System.out.println("count = " + count);
        return count;
    }

    @Override
    public int selectByIdAndName(int id,String name) {
        System.out.println("selectByIdAndName work...");
        return id;
    }
}
