SELECT ARTIST.ARTISTID AS "Artist ID", ALBUM.ALBUMID AS "Album ID", TRACK.TRACKID AS "Track Number", PLAYLIST.PLAYLISTID AS "Playlist ID", 
GENRE.GENREID AS "Genre ID", MEDIATYPE.MEDIATYPEID AS "Mediatype ID", INVOICE.INVOICEID AS "Invoice ID", CUSTOMER.CUSTOMERID AS "Customer ID", 
EMPLOYEE.REPORTSTO AS "Customer Support ID"
FROM ARTIST
INNER JOIN ALBUM on ARTIST.ARTISTID = ALBUM.ARTISTID
INNER JOIN TRACK ON TRACK.ALBUMID = ALBUM.ALBUMID--
INNER JOIN PLAYLISTTRACK ON PLAYLISTTRACK.TRACKID = TRACK.TRACKID--
INNER JOIN PLAYLIST ON PLAYLIST.PLAYLISTID = PLAYLISTTRACK.PLAYLISTID--
INNER JOIN GENRE ON GENRE.GENREID = TRACK.GENREID
INNER JOIN MEDIATYPE ON MEDIATYPE.MEDIATYPEID = TRACK.MEDIATYPEID
INNER JOIN INVOICELINE ON INVOICELINE.TRACKID = TRACK.TRACKID
INNER JOIN INVOICE ON INVOICE.INVOICEID = INVOICELINE.INVOICEID
INNER JOIN CUSTOMER ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID
INNER JOIN EMPLOYEE ON EMPLOYEE.EMPLOYEEID = CUSTOMER.SUPPORTREPID;