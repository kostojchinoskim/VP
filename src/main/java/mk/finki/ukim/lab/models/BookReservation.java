package mk.finki.ukim.lab.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookReservation {
    private String bookTitle;
    private String readerName;
    private String readerAddress;
    private Long numberOfCopies;
}
