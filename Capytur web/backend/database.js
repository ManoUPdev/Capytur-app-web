const express = require('express');
const router = express.Router();

// Retorna todos os voos (mock ou do banco)
router.get('/', (req, res) => {
    res.json([
        { id: 1, from: "São Paulo", to: "Rio de Janeiro", price: 200 },
        { id: 2, from: "São Paulo", to: "Belo Horizonte", price: 250 }
    ]);
});

// Retorna detalhes de um voo
router.get('/:id', (req, res) => {
    const flightId = req.params.id;
    res.json({ id: flightId, from: "São Paulo", to: "Rio de Janeiro", price: 200, duration: "1h10m" });
});

module.exports = router;
