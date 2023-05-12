+auction(ID, EXIT, C)[source(S)] : not occupied(park_place4) & auction(ID, 7, C)
   <- .send(S, tell, place_bid(EXIT, 2, C)).

+auction(ID, EXIT, C)[source(S)] : not occupied(park_place4) & auction(ID, 8, C)
   <- .send(S, tell, place_bid(EXIT, 2, C)).

+auction(ID, EXIT, C)[source(S)] : not occupied(park_place4) & not auction(ID, 7, C) & not auction(ID, 8, C)
   <- .send(S, tell, place_bid(EXIT, 1, C)).

+auction(ID, EXIT, C)[source(S)] : occupied(park_place4)
   <- .send(S, tell, place_bid(EXIT, 0, C)).
