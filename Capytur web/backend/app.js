const express = require('express');
const app = express();
const flightsRoutes = require('./routes/flights');
const reservationsRoutes = require('./routes/reservations');
const hotelsRoutes = require('./routes/hotels');

app.use(express.json());
app.use('/api/flights', flightsRoutes);
app.use('/api/reservations', reservationsRoutes);
app.use('/api/hotels', hotelsRoutes);

const PORT = 3000;
app.listen(PORT, () => console.log(`Server running on port ${PORT}`));