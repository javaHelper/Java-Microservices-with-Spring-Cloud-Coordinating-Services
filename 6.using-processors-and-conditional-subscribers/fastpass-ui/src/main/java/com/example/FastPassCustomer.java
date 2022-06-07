package com.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FastPassCustomer {
    private String fastPassId;
    private String customerFullName;
    private String customerPhone;
    private Float currentBalance;
}
