drop table if exists camp_entity CASCADE;

create table camp_entity (
    camp_id bigint not null generated by default as identity,
    camp_address varchar(255),
    camp_check_in varchar(255),
    camp_check_out varchar(255),
    camp_description varchar(255),
    camp_imgx varchar(255),
    camp_name varchar(255),
    camp_phone varchar(255),
    camp_rating varchar(255),
    camp_rating_cnt varchar(255),
    camp_summary varchar(255),
    camp_url varchar(255),
    camp_x_loc varchar(255),
    camp_y_loc varchar(255),
    primary key (camp_id)
);