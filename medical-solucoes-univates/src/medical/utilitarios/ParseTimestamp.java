/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medical.utilitarios;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author loren
 */
public class ParseTimestamp {
    
    public static Timestamp parse(String data){
        Integer dia = Integer.parseInt(data.split("/")[0]);
        Integer mes = Integer.parseInt(data.split("/")[1]);
        Integer ano = Integer.parseInt(data.split("/")[2].split(" ")[0]);
        Integer hora = Integer.parseInt(data.split(" ")[1].split(":")[0]);
        Integer minuto = Integer.parseInt(data.split(" ")[1].split(":")[1]);
        LocalDateTime localDate = LocalDateTime.of(ano, mes, dia, hora, minuto);
        Timestamp dataTimestamp = java.sql.Timestamp.valueOf(localDate);
        
        return dataTimestamp;
    }
    
}
