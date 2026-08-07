// ===================================================
// DOM READY
// ===================================================

document.addEventListener("DOMContentLoaded", () => {

    const form = document.getElementById("journeyForm");

    const submitBtn = document.getElementById("submitBtn");

    const fullName = document.getElementById("fullName");

    const mobile = document.getElementById("mobile");

    const mobileError = document.getElementById("mobileError");

    const arrivalDate = document.getElementById("arrivalDate");

    const returnDate = document.getElementById("returnDate");

    const pickupRequired = document.getElementById("pickupRequired");

    const pickupLocationSection =
        document.getElementById("pickupLocationSection");

    const hotelRequired =
        document.getElementById("hotelRequired");

    const hotelCategorySection =
        document.getElementById("hotelCategorySection");


    // ===================================================
    // TODAY DATE
    // ===================================================

    const today = new Date().toISOString().split("T")[0];

    arrivalDate.min = today;

    returnDate.min = today;


    // ===================================================
    // ARRIVAL DATE CHANGE
    // ===================================================

    arrivalDate.addEventListener("change", () => {

        returnDate.min = arrivalDate.value;

        if (returnDate.value < arrivalDate.value) {

            returnDate.value = "";

        }

    });


    // ===================================================
    // PICKUP SECTION
    // ===================================================

    function togglePickup() {

        pickupLocationSection.style.display =
            pickupRequired.value === "true"
                ? "flex"
                : "none";

    }

    togglePickup();

    pickupRequired.addEventListener("change", togglePickup);


    // ===================================================
    // HOTEL SECTION
    // ===================================================

    function toggleHotel() {

        hotelCategorySection.style.display =
            hotelRequired.value === "true"
                ? "flex"
                : "none";

    }

    toggleHotel();

    hotelRequired.addEventListener("change", toggleHotel);


    // ===================================================
    // NAME VALIDATION
    // ===================================================

    fullName.addEventListener("input", function () {

        this.value = this.value.replace(/[^a-zA-Z\s]/g, "");

    });


    // ===================================================
    // MOBILE VALIDATION
    // ===================================================

    mobile.addEventListener("input", function () {

        this.value = this.value.replace(/\D/g, "");

        if (this.value.length > 10) {

            this.value = this.value.slice(0, 10);

        }

        if (this.value.length > 0 &&
            this.value.length < 10) {

            mobileError.innerHTML =
                "Please enter a valid 10-digit mobile number.";

        } else {

            mobileError.innerHTML = "";

        }

    });


    // ===================================================
    // FORM SUBMIT
    // ===================================================

    form.addEventListener("submit", function (e) {

        // Name

        if (fullName.value.trim().length < 3) {

            alert("Please enter your full name.");

            fullName.focus();

            e.preventDefault();

            return;

        }


        // Mobile

        if (mobile.value.length !== 10) {

            alert("Please enter a valid mobile number.");

            mobile.focus();

            e.preventDefault();

            return;

        }


        // Arrival

        if (arrivalDate.value < today) {

            alert("Arrival Date cannot be in the past.");

            arrivalDate.focus();

            e.preventDefault();

            return;

        }


        // Return

        if (returnDate.value < arrivalDate.value) {

            alert("Return Date cannot be earlier than Arrival Date.");

            returnDate.focus();

            e.preventDefault();

            return;

        }


        // Loading Button

        submitBtn.disabled = true;

        submitBtn.classList.add("loading");

        submitBtn.innerHTML =
            '<i class="fa-solid fa-spinner fa-spin"></i> Submitting...';

    });

});