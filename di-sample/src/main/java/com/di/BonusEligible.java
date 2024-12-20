package com.di;

// Interface to handle bonuses
interface BonusEligible {
    // Static constant
    String DEFAULT_BONUS = "Biden";

    String getBonus();
    void setBonus(String bonus);
}
