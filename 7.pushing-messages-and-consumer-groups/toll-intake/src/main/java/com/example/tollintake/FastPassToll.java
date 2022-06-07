package com.example.tollintake;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FastPassToll {
    private String fastPassId;
    private String stationId;
    private Float amountPaid;
    private String status;
}
