package com.smu.l03_emp_model2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DBFactoryTest {

    @Test
    void getConn() throws Exception{
        System.out.println(DBFactory.getConn());
    }
}