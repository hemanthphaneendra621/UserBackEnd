//package com.company.main;
//
//import com.company.cli.UserCli;
//import com.company.cli.impl.UserCliOperations;
//
//
//public class Main {
//    @SuppressWarnings("unchecked")
//    public static void main(String[] args) {
//        /**
//         * creating a new instance of cliOperations of product , user and order.
//         * taking the choice value from productCliOperations and performing the required actions based on the choice
//         */
//        UserCli userCliOperations = new UserCliOperations();
//
//                    String userInput = userCliOperations.userInput();
//                    label:
//                    while(userInput.equals("1") || userInput.equals("2") || userInput.equals("3") || userInput.equals("4") || userInput.equals("5")){
//                        switch (userInput){
//                            /**
//                             * if the userInput is 1
//                             * perform actions to add userObject to the database.
//                             */
//                            case "1":
////                                userCliOperations.firstNameCli();
////                                userCliOperations.lastNameCli();
////                                userCliOperations.emailCli();
////                                userCliOperations.phoneCli();
////                                userCliOperations.address1Cli();
////                                userCliOperations.address2Cli();
////                                userCliOperations.cityCli();
////                                userCliOperations.stateCli();
////                                userCliOperations.countryCli();
////                                userCliOperations.postalCodeCli();
//                                userCliOperations.createUserObject();
//                                userInput = userCliOperations.userInput();
//                                break;
//                            /**
//                             * if the userInput is 2
//                             * perform actions to delete userObject from the database.
//                             */
//                            case "2":
//                                userCliOperations.deleteUserObject();
//                                userInput = userCliOperations.userInput();
//                                break;
//                            /**
//                             * if the userInput is 3
//                             * perform actions to update userObject to the database.
//                             */
//                            case "3":
//                                userCliOperations.updateUserObject();
//                                userInput = userCliOperations.userInput();
//                                break;
//                            /**
//                             * if the userInput is 4
//                             * perform actions to retrieve userObject from the database.
//                             */
//                            case "4":
//                                userCliOperations.getUserObject();
//                                userInput = userCliOperations.userInput();
//                                break;
//                            /**
//                             * if the userInput is 5
//                             * breaks of from the loop.
//                             */
//                            default:
//                                break label;
//                        }
//                    }
//
//
//            }
//
//
//}
