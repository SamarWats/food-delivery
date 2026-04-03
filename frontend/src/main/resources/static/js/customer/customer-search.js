    function fetchAnalytics() {
        const id = document.getElementById("customerId").value;
        const error = document.getElementById("error");

        if (!id || id <= 0) {
            error.classList.remove("hidden");
            return;
        }

        error.classList.add("hidden");
        window.location.href = `/customers/${id}/analytics`;
    }

    // Enter key support
    document.getElementById("customerId").addEventListener("keypress", function(e) {
        if (e.key === "Enter") fetchAnalytics();
    });

    // Numbers only
    document.getElementById("customerId").addEventListener("input", function() {
        this.value = this.value.replace(/[^0-9]/g, '');
    });

    // Auto focus
    window.addEventListener("load", () => {
        document.getElementById("customerId").focus();
    });