/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package surveysystem;

/**
 *
 * @author tanvi
 */

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionProvider {
    public static Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/oss";
        String user = "root";
        String password = "";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");  
            Connection conn=DriverManager.getConnection(url,user,password);  
            return conn;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error! Could not connect to the database!" + e);
            return null;
        }
    }
}

/*

create table user_details(
userid int auto_increment,
username varchar(255) not null,
password varchar(255) not null,
contact varchar(10) not null,
emailid varchar(255) not null,
num_surveys_submitted int default 0 not null,
num_surveys_created int default 0 not null,
primary key(userid)
);


create table survey_details(
survey_id int auto_increment,
survey_name varchar(255) not null,
num_questions int not null,
created_by int not null,
created_on timestamp default current_timestamp,
num_participants int default 0 not null,
primary key(survey_id)
);

create table questions(
id int auto_increment,
survey_id int not null,
question varchar(255) not null,
opt1 varchar(255) not null,
opt2 varchar(255) not null,
opt3 varchar(255) not null,
opt4 varchar(255) not null,
cnt1 int default 0 not null,
cnt2 int default 0 not null,
cnt3 int default 0 not null,
cnt4 int default 0 not null,
primary key(id)
);


create table log(
userid int not null,
surveyid int not null,
date timestamp default current_timestamp
);

create table log_questions(
user_id int not null,
question_id int not null,
opt int not null,
ans varchar(255) not null
);


*/