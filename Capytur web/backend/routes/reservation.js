const express = require('express');
const router = express.Router();

router.post('/', (req, res) => {
    
const reservation = req.body;

res.json({message: "Reserva realizada com sucesso!", reservation});
});

module.exports = router;