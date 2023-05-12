+!start_auction(ID, EXIT): not parked(car4)
    <- +parked(car4); 
    .send(gate, tell, start_auction(ID, EXIT)).


+!start_auction(ID, EXIT): parked(car4)
    <- true.
