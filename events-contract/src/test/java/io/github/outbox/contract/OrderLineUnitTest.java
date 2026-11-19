package io.github.outbox.contract;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderLineUnitTest {

    @Test
    @DisplayName("UT constructor() when productId is null should throw NullPointerException")
    void constructor_whenProductIdIsNull_shouldThrowNullPointerException() {
        // when / then
        assertThatThrownBy(() -> new OrderLine(null, 2, new BigDecimal("10.50")))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("productId cannot be null");
    }

    @Test
    @DisplayName("UT constructor() when price is null should throw NullPointerException")
    void constructor_whenPriceIsNull_shouldThrowNullPointerException() {
        // when / then
        assertThatThrownBy(() -> new OrderLine("sku-1", 2, null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("price cannot be null");
    }

    @Test
    @DisplayName("UT constructor() should preserve the provided values")
    void constructor_shouldPreserveProvidedValues() {
        // given
        String productId = "sku-1";
        int quantity = 2;
        BigDecimal price = new BigDecimal("10.50");

        // when
        OrderLine tested = new OrderLine(productId, quantity, price);

        // then
        assertThat(tested.productId()).isEqualTo(productId);
        assertThat(tested.quantity()).isEqualTo(quantity);
        assertThat(tested.price()).isEqualTo(price);
    }
    
}
