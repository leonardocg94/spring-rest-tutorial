insert into user_details(id, birth_date, name) 
  values (1001, current_date(), 'Leonardo'),
    (1002, current_date(), 'Carlos'),
    (1003, current_date(), 'Gabriel'),
    (1004, current_date(), 'Brian'),
    (1005, current_date(), 'Astrid');

insert into post(id, description, user_id)
  values (2001, 'quiero aprender aws', 1001),
    (2002, 'quiero aprender microservicios', 1001),
    (2003, 'quiero aprender docker', 1002),
    (2004, 'quiero aprender kubernettes', 1002),
    (2005, 'quiero aprender vue', 1003),
    (2006, 'quiero aprender react', 1003),
    (2007, 'quiero aprender angular', 1004),
    (2008, 'quiero aprender spring', 1004),
    (2009, 'quiero aprender after effects', 1005);