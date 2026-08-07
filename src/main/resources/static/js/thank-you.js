// ==========================================
// THANK YOU PAGE
// ==========================================

// Countdown Timer

let seconds = 90;

const countdown = document.getElementById("countdown");

const timer = setInterval(() => {

    seconds--;

    countdown.textContent = seconds;

    if (seconds <= 0) {

        clearInterval(timer);

        window.location.href = "/";

    }

}, 1000);


// ==========================================
// Fade In Animation
// ==========================================

window.addEventListener("load", () => {

    document.querySelector(".thank-card").style.opacity = "1";

});