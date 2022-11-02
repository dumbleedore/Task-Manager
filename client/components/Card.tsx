import { Box, Button, Heading, Text, HStack } from "@chakra-ui/react";
import React from "react";
import Task from "../interface/task";

// create a simple card component with description //
export const Card: React.FC<Task> = (props) => {
  return (
    <Box
      bg="secondary"
      w={"100%"}
      m={2}
      p={4}
      borderRadius="md"
      boxShadow="md"
      color="white"
      flex={"1 0 30%"}
    >
      <Heading size="lg">{props.nome}</Heading>
      <HStack>
        <Text as={"b"}>Descrição</Text>
        <Text>{props.descricao}</Text>
      </HStack>
      <HStack>
        <Text as={"b"}>Status: </Text>
        <Text>{props.status}</Text>
      </HStack>
      <Button colorScheme="blue">Complete Task</Button>
    </Box>
  );
};
