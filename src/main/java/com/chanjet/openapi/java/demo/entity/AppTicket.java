package com.chanjet.openapi.java.demo.entity;

import lombok.*;

import javax.persistence.*;

/**
 * ticket信息
 *
 * @author: zsc
 * @create: 2020/11/6 11:04 上午
 **/
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "app_ticket")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppTicket extends AbstractBaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_app_ticket")
    @SequenceGenerator(name = "seq_app_ticket", sequenceName = "SEQ_APP_TICKET_ID", initialValue = 10000, allocationSize = 1)
    private Long id;
    /**
     * 开放平台appKey
     */
    private String appKey;
    /**
     * 开放平台推送的appTicket
     */
    private String ticket;
}
