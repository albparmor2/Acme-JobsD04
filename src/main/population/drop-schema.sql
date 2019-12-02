
    alter table `administrator` 
       drop 
       foreign key FK_2a5vcjo3stlfcwadosjfq49l1;

    alter table `anonymous` 
       drop 
       foreign key FK_6lnbc6fo3om54vugoh8icg78m;

    alter table `authenticated` 
       drop 
       foreign key FK_h52w0f3wjoi68b63wv9vwon57;

    alter table `consumer` 
       drop 
       foreign key FK_6cyha9f1wpj0dpbxrrjddrqed;

    alter table `message` 
       drop 
       foreign key `FK3ny0h1379q528toyokq81noiu`;

    alter table `provider` 
       drop 
       foreign key FK_b1gwnjqm6ggy9yuiqm0o4rlmd;

    alter table `thread` 
       drop 
       foreign key `FKkoj53cnb5t2fhfm33gb9bvff1`;

    alter table `thread_message` 
       drop 
       foreign key `FKrjegm8cujrxgbce9n1b78xuyo`;

    alter table `thread_message` 
       drop 
       foreign key `FKgjodhp3io8v829t92y1tdtb7u`;

    drop table if exists `administrator`;

    drop table if exists `announcement`;

    drop table if exists `anonymous`;

    drop table if exists `authenticated`;

    drop table if exists `challenge`;

    drop table if exists `commercial_banner`;

    drop table if exists `company_record`;

    drop table if exists `consumer`;

    drop table if exists `customisation`;

    drop table if exists `investor_record`;

    drop table if exists `message`;

    drop table if exists `non_commercial_banner`;

    drop table if exists `offer`;

    drop table if exists `provider`;

    drop table if exists `requesta`;

    drop table if exists `shout`;

    drop table if exists `thread`;

    drop table if exists `thread_message`;

    drop table if exists `user_account`;

    drop table if exists `hibernate_sequence`;
