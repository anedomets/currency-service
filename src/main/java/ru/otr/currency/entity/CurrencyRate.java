package ru.otr.currency.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "currency_rate")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private ZonedDateTime date;

    @Column(name = "previous_date")
    private ZonedDateTime previousDate;

    @Column(name = "previous_url")
    private String previousUrl;

    @Column(name = "timestamp")
    private ZonedDateTime timestamp;

    @Column(name = "create_date")
    @CreationTimestamp
    private ZonedDateTime createDate;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "currency_rate_id")
    private List<Currency> currencies = new ArrayList<>();

}
