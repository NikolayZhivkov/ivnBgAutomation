package pojo;

import lombok.Data;

//така добавям lombok библиотеката
//това ще ми даде опция да създам конструктор на един ред от всички полета
//@data ще имам out of the box създадени гетъри и сетъри
@Data
//@AllArgsConstructor //като инстанцирам такъв обект имам опция да не използвам сетъри и гетъри

public class BankAccount {

    private String bank_name;
    private String bank_name_en;
    private String bank_bic;
    private String bank_iban;




    //това се казва поджо plain java object понеже има само полета и конструктори
    //тук в момента има дефолтен конструктор
    // какво представлява банковата сметка
    //тоса полетат , който трябва да подадем като gson за да може да създадем банковата сметка
}

