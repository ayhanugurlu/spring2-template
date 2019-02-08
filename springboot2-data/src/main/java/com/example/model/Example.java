package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Ayhan.Ugurlu on 08/02/2019
 */
@Entity
public class Example {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String var1;
    String var2;
    String var3;
    String var4;
}
