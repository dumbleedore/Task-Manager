import { Box, Container, Flex, HStack } from "@chakra-ui/react";
import { Card } from "../components/Card";

export default function Home() {
  return (
    <Box bg="primary">
      <Flex wrap={"wrap"}>
        <Card></Card>
        <Card></Card>
        <Card></Card>
        <Card></Card>
      </Flex>
    </Box>
  );
}
