+auction(ID, EXIT, C)[source(S)] : not occupied(park_place2) & auction(ID, 3)
   <- .send(S, tell, place_bid(EXIT, 2, C)).

+auction(ID, EXIT, C)[source(S)] : not occupied(park_place2) & auction(ID, 4)
   <- .send(S, tell, place_bid(EXIT, 2, C)).

+auction(ID, EXIT, C)[source(S)] : not occupied(park_place2) & not auction(ID, 3) & not auction(ID, 4)
   <- .send(S, tell, place_bid(EXIT, 1, C)).

+auction(ID, EXIT, C)[source(S)] : occupied(park_place2)
   <- .send(S, tell, place_bid(EXIT, 0, C)).
