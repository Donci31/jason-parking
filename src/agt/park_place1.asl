+auction(ID, EXIT, C)[source(S)] : not occupied(park_place1) & auction(ID, 1)
   <- .send(S, tell, place_bid(EXIT, 2, C)).

+auction(ID, EXIT, C)[source(S)] : not occupied(park_place1) & auction(ID, 2)
   <- .send(S, tell, place_bid(EXIT, 2, C)).

+auction(ID, EXIT, C)[source(S)] : not occupied(park_place1) & not auction(ID, 1) & not auction(ID, 2)
   <- .send(S, tell, place_bid(EXIT, 1, C)).

+auction(ID, EXIT, C)[source(S)] : occupied(park_place1)
   <- .send(S, tell, place_bid(EXIT, 0, C)).
