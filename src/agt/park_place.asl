!start.
+!start
   <- .send(gate, tell, spawn_parking_place).

+auction(EXIT, CAR)[source(S)] : not occupied & distance_to_exit(EXIT, D) & D > 0
   <- .print("I send a bid for car ", CAR, " , who wants to exit at ", EXIT, ". My bid is ", D);
      .send(S, tell, place_bid(D, CAR)).

+auction(EXIT, CAR)[source(S)] : occupied
   <- .print("I am occupied, so I am bidding 0");
      .send(S, tell, place_bid(0, CAR)).
