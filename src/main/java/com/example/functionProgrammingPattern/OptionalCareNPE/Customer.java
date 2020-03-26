package com.example.functionProgrammingPattern.OptionalCareNPE;


import java.util.Optional;

import static java.util.Optional.ofNullable;

public class Customer {
    private MemberCard memberCard;

    public Customer() {

    }

    public Customer(MemberCard memberCard) {
        this.memberCard = memberCard;
    }

    public Optional<MemberCard> getMemberCard() {
        return ofNullable(memberCard);
    }
}
