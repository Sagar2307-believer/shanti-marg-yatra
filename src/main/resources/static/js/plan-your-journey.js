// ======================================
// DOM Ready
// ======================================

document.addEventListener("DOMContentLoaded", function () {

    const pickupRequired = document.getElementById("pickupRequired");
    const pickupLocationSection = document.getElementById("pickupLocationSection");

    const hotelRequired = document.getElementById("hotelRequired");
    const hotelCategorySection = document.getElementById("hotelCategorySection");

    const form = document.getElementById("journeyForm");

    const submitBtn = document.getElementById("submitBtn");

    const mobile = document.getElementById("mobile");
    const mobileError = document.getElementById("mobileError");

    // ===============================
    // Pickup Show / Hide
    // ===============================

    function togglePickup() {

        if (pickupRequired.value === "true") {

            pickupLocationSection.style.display = "flex";

        } else {

            pickupLocationSection.style.display = "none";

        }

    }

    togglePickup();

    pickupRequired.addEventListener("change", togglePickup);




    // ===============================
    // Hotel Show / Hide
    // ===============================

    function toggleHotel() {

        if (hotelRequired.value === "true") {

            hotelCategorySection.style.display = "flex";

        } else {

            hotelCategorySection.style.display = "none";

        }

    }

    toggleHotel();

    hotelRequired.addEventListener("change", toggleHotel);




    // ===============================
    // Mobile Validation
    // ===============================

    mobile.addEventListener("input", function () {

        this.value = this.value.replace(/\D/g, "");

        if (this.value.length > 10) {

            this.value = this.value.slice(0, 10);

        }

        if (this.value.length > 0 && this.value.length < 10) {

            mobileError.innerHTML = "Please enter a valid 10-digit mobile number.";

        } else {

            mobileError.innerHTML = "";

        }

    });




    // ===============================
    // Date Validation
    // ===============================

    form.addEventListener("submit", function (e) {

        const arrivalDate =
            document.querySelector("[name='arrivalDate']").value;

        const returnDate =
            document.querySelector("[name='returnDate']").value;

        if (arrivalDate !== "" && returnDate !== "") {

            if (returnDate < arrivalDate) {

                alert("Return Date cannot be earlier than Arrival Date.");

                e.preventDefault();

                return;

            }

        }




        // Mobile Validation

        if (mobile.value.length !== 10) {

            alert("Please enter a valid Mobile Number.");

            mobile.focus();

            e.preventDefault();

            return;

        }




        // Loading Button

        submitBtn.classList.add("loading");

        submitBtn.disabled = true;

        submitBtn.innerHTML = "Submitting...";

    });

});