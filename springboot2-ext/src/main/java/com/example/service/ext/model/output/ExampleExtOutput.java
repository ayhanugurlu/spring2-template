package com.example.service.ext.model.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

/**
 * Created by Ayhan.Ugurlu on 08/02/2019
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExampleExtOutput {
    String var1;
    String var2;
    String var3;
    String var4;
}
