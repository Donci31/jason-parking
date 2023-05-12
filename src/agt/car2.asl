+!start_auction(ID, EXIT): not parked(car1)
    <- +parked(car2); 
    .send(gate, tell, start_auction(ID, EXIT)).


+!start_auction(ID, EXIT): parked(car1)
    <- true.
