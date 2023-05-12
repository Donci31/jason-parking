+!start_auction(ID, EXIT): not parked(_)
    <- .send(gate, tell, start_auction(ID, EXIT)).


+!start_auction(ID, EXIT): parked(_)
    <- true.
