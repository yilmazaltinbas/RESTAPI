package staj.RESTAPI.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name="kisi")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of={"id"})
@ToString
public class Kisi {

    @Id
    @SequenceGenerator(name = "seq_kisi",allocationSize = 1)
    @GeneratedValue(generator = "seq_kisi", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100, name="adi")
    private String adi;
    @Column(length = 100, name="soyadi")
    private String soyadi;

    @OneToMany // bir kişi bir çok adres eklenebilir
    @JoinColumn(name= "kisi_adres_id")
    private List<Adres> adresleri; // bir kişinin birden fazla adresi olabilir ve bunları listede tutuyoruz

}
