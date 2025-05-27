package com.example.back_end.AiProfileApp.entity;

import com.example.back_end.AiProfileApp.entity.extra.TransactionDescription;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private TransactionDescription description;
    private Integer amount;
}
