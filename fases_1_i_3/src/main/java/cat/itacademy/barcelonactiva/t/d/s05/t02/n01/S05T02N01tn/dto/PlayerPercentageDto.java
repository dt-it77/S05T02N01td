package cat.itacademy.barcelonactiva.t.d.s05.t02.n01.S05T02N01tn.dto;

import java.math.BigDecimal;
import java.time.LocalDate;


public class PlayerPercentageDto {
    
    private String name;
    private LocalDate registerDate;
    private BigDecimal percentage;

    public PlayerPercentageDto(String name, LocalDate registerDate, BigDecimal percentage){
        this.name = name;
        this.registerDate = registerDate;        
        this.percentage = percentage;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setLocalDate(LocalDate localDate){
        this.registerDate = localDate;
    }
    public LocalDate getLocalDate(){
        return registerDate;
    }
    public void setPercentage(BigDecimal percentage){
        this.percentage = percentage;
    }
    public BigDecimal getPercentage(){
        return percentage;
    }

}
