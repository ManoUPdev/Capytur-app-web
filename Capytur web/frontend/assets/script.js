const urlParams = new URLSearchParams(window.location.search);
const searchQuery = urlParams.get('search');
document.getElementById('flightId').value = flightId;

const form = document.getElementById('reservationForm');
form.addEventListener('submit', async(e) => {
    e.preventDefault();


const reservationData = {
    flightId: document.getElementById('flightId').value,
    name: document.getElementById('name').value,
    email: document.getElementById('email').value,
};

try {
    const response = await fetch('/api/reservations', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json', },
        body: JSON.stringify(reservationData),
    });

    const result = await response.json();
    document.getElementById('result').innerText = result.message;

    form.reset()
} catch (error) {
    document.getElementById('result').innerText = 'An error occurred while making the reservation.';
    console.error('Error:', error);
}
});

