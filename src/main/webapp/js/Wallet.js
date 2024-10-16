function validateInput(event, type) {
    const amountInput = event.target.querySelector('input[type="text"]');
    const amount = parseInt(amountInput.value, 10);
    if (amount < 0) {
        event.preventDefault();
        alert('금액은 0원부터 입력 가능합니다..');
    }
}
    $(document).ready(function() {
        $('#charge-amount').on('input', function() {
            this.value = this.value.replace(/[^0-9]/g, '');
        });

        $('#balance').on('input', function() {
            this.value = this.value.replace(/[^0-9]/g, '');
        });
    });