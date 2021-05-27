package com.golden.transport.util;


import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class ClientIdGenerator implements IdentifierGenerator {
    int year = 19;


    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        String prefix = "INVO_";
        Connection connection = sharedSessionContractImplementor.connection();


        try {
            Statement statement=connection.createStatement();

            ResultSet rs=statement.executeQuery("select count(id) as Id from invoices");

            if(rs.next())
            {
                int id=rs.getInt(1)+100001;
                String generatedId = prefix + getYearSigne() + new Integer(id).toString();
                return generatedId;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
    public String getYearSigne(){
        String str = "";
        try{
            Date date3 = new Date();
            LocalDate ld1 = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date3)); // Accepts only yyyy-MM-dd
            int day  = ld1.getDayOfMonth();
            int month= ld1.getMonthValue();
            year = ld1.getYear();
             str = String.valueOf(year).substring(2,4);
        }
        catch(NumberFormatException e){
        }
        return str;
    }
}
