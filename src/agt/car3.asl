+!start_auction(ID, EXIT): not parked(car3)
    <- +parked(car3); 
    .send(gate, tell, start_auction(ID, EXIT)).


+!start_auction(ID, EXIT): parked(car3)
    <- true.
