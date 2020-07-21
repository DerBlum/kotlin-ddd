db.createUser({
    user: 'demouser',
    pwd: 'demopw',
    roles: [
        {
            role: 'readWrite',
            db: 'library',
        },
    ],
});
