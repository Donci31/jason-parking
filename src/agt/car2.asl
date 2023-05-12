+!start_auction(ID, EXIT): not parked(car2)
    <- +parked(car2); 
    .send(gate, tell, start_auction(ID, EXIT)).


+!start_auction(ID, EXIT): parked(car2)
    <- true.
