package com.vhs.rental.form;

import com.vhs.rental.model.User;
import com.vhs.rental.model.Vhs;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class RentalForm {

    @NotNull
    private Long userId;

    @NotNull
    private Long vhsId;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    private LocalDate dateReturned;

}

