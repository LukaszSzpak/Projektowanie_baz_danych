INSERT INTO user (id, email, name, password, surname)
VALUES (0, 'email@email.pl', 'Lukas', 'pass', 'Szpak');

INSERT INTO user (id, email, name, password, surname)
VALUES (1, 'piotrek@email.pl', 'Piotr', 'pass', 'Bobel');

INSERT INTO user (id, email, name, password, surname)
VALUES (2, 'pitorek2@email.pl', 'Piotr2', 'pass', 'Au..');


INSERT INTO book (id, title, author, description, available)
VALUES (0,
    'Wiele do stracenia',
    'Marek Marcinowski',
    'Andrew Freshet sądzi, że złapał szczęście za ogon. Pnie się po szczeblach kariery w jednym z nowojorskich banków inwestycyjnych.',
    1);

INSERT INTO book (id, title, author, description, available)
VALUES (1,
    'Baśń o wężowym sercu albo wtóre słowo o Jakóbie Szeli',
    'Radek Rak',
    'Baśń jest próbą stworzenia na nowo mitologii Galicji. Nie jest powieścią historyczną, i choć napisana z dużym szacunkiem dla ówczesnych realiów społecznych.',
    True);

INSERT INTO book (id, title, author, description, available)
VALUES (2,
    'Precedens',
    'Remigiusz Mróz',
    'Do Joanny Chyłki z nietypową sprawą zgłasza się jedna z najpopularniejszych polskich aktorek. Twierdzi, że za moment popełni przestępstwo.',
    True);


INSERT INTO book_user_wish_list (wish_list_id, user_wish_list_id)
VALUES (0, 2);

INSERT INTO book_user_wish_list (wish_list_id, user_wish_list_id)
VALUES (1, 1);


INSERT INTO employee (id, email, name, password, role, surname)
VALUES (0, 'root@root.pl', 'admin', 'root', 'ADMIN', 'admin_surname');

INSERT INTO employee (id, email, name, password, role, surname)
VALUES (1, 'librarian@db.pl', 'librarian', 'librarian', 'LIBRARIAN', 'librarian_surname');


INSERT INTO item (id, available, condition, publish_house, book_id)
VALUES (0, 1, 'Dobry', 'Anatta', 0);

INSERT INTO item (id, available, condition, publish_house, book_id)
VALUES (1, 1, 'Idealny', 'Anatta', 0);

INSERT INTO item (id, available, condition, publish_house, book_id)
VALUES (2, 1, 'Idealny', 'Powergraph', 1);

INSERT INTO item (id, available, condition, publish_house, book_id)
VALUES (3, 1, 'Uszkodzona', 'Czwarta Strona', 2);

INSERT INTO item (id, available, condition, publish_house, book_id)
VALUES (4, 1, 'Bardzo dobry', 'Czwarta Strona', 2);


INSERT INTO loan (id, additional_cost, date_planning_return, days_after_return_date, is_back,
                    rent_date, employee_id, item_id, user_id)
VALUES (0, 0, TO_TIMESTAMP('2021-01-30 0:00:00.000000', 'YYYY-MM-DD HH24:MI:SS.FF'), 0, 0,
    TO_TIMESTAMP('2021-02-15 0:00:00.000000', 'YYYY-MM-DD HH24:MI:SS.FF'), 1, 3, 0);