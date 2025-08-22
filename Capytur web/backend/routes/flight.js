const express = require('express');
const router = express.Router();

router.get('/',(req,res) =>  {
    res.json([
        { id: 1, from: "Sao Paulo", to: "Rio de Janeiro", price: 200},
        { Id: 2, from: "Sao Paulo", to: "Belo Horizonte", price: 250}

    ]);

});

router.get('/:id', (req, res) => {
    const flightId = req.params.id;
    res.json({ id: flightId, from: "Sao Paulo", to: "Rio de Janeiro", price:200, duration: "35min"});

});
module.exports = router;