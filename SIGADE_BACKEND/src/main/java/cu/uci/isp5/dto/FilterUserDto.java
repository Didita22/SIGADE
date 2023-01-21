/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cu.uci.isp5.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author Didi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilterUserDto {
    private String name;
    private String lastName;
    private String username;
    private String lapel;
    private String sex;
    private String ci;
    private String type;
}
