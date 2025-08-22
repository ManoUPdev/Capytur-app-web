const express = require('express');
const router = express.Router();

router.get('/', (req, res) => {
    res.json([
        { id: 1, name: 'Hotel Sol', location: 'Rio de Janeiro', price: 300 },
        { id: 2, name: 'Hotel Azul', location: 'Sao Paulo', price: 250 },
        { id: 3, name: 'Hotel Pioneiro', location: 'Belo Horizonte',price: 200}    
    ]);
});


router.get('/:id', (req, res) => {
    const hotelId = req.params.id;
    res.json({ 
        id: hotelId,
        name: 'Hotel Sol',
        location: 'Rio de Janeiro',
        price: 300,
        amenities: ['Wi-Fi', 'Piscina', 'Cafe da Manha'],
        description: "Um hotel confortavel proximo a praia.",
        images: ["hotel1.jpg", "hotel2.jpg"]
    });
});

module.exports = router;