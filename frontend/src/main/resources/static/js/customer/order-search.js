    function fetchOrders() {
        const id = document.getElementById("customerId").value.trim();
        const error = document.getElementById("error");

        if (!id || id <= 0) {
            error.classList.remove("hidden");
            return;
        }

        error.classList.add("hidden");
        window.location.href = `/customers/${id}/orders`;
    }

    // Enter key + number validation
    document.getElementById("customerId").addEventListener("keypress", function(e) {
        if (e.key === "Enter") fetchOrders();
    });

    document.getElementById("customerId").addEventListener("input", function() {
        this.value = this.value.replace(/[^0-9]/g, '');
    });

    window.addEventListener("load", () => {
        document.getElementById("customerId").focus();
    });